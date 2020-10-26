package com.tmf.Repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.WriteModel;
import com.tmf.Models.Patch;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class MongoDBPatchRepository implements  PatchRepository {
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    @Autowired
    private MongoClient client;
    private MongoCollection<Patch> patchCollection;

    @PostConstruct
    void init() {
        patchCollection = client.getDatabase("patchwork_db").getCollection("patches", Patch.class);
    }

    @Override
    public Patch save(Patch patch){
        patch.setId(new ObjectId());
        patchCollection.insertOne(patch);
        return patch;
    }

    @Override
    public List<Patch> saveAll(List<Patch> patches){
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                patches.forEach(p -> p.setId(new ObjectId()));
                patchCollection.insertMany(clientSession, patches);
                return patches;
            }, txnOptions);
        }
    }

    @Override
    public List<Patch> findAll() {
        return patchCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Patch> findAll(List<String> ids) {
        return patchCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    @Override
    public Patch findOne(String id) {
        return patchCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public long count() {
        return patchCollection.countDocuments();
    }

    @Override
    public long delete(String id){
        return patchCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public long delete(List<String> ids) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> patchCollection.deleteMany(clientSession, in("_id", mapToObjectIds(ids))).getDeletedCount(), txnOptions);
        }
    }

    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> patchCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    @Override
    public Patch update(String id, Patch patch) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return patchCollection.findOneAndReplace(eq("_id", new ObjectId(id)), patch, options);
    }

    @Override
    public long update(List<Patch> patches){
        List<WriteModel<Patch>> writes = patches.stream().map(p-> new ReplaceOneModel<>(eq("_id", p.getId()), p)).collect(Collectors.toList());

        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> patchCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }
    }

    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
