package com.logineko.telemetrydatahub.infrastructure;

import com.logineko.telemetrydatahub.model.domain.Machine;
import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;
import net.ravendb.client.serverwide.DatabaseRecord;
import net.ravendb.client.serverwide.operations.CreateDatabaseOperation;
import net.ravendb.client.serverwide.operations.GetDatabaseRecordOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentStoreHolder {
    @Bean
    public static IDocumentStore getStore() {
        return DocumentStoreContainer.store;
    }

    private static class DocumentStoreContainer {
        public static final IDocumentStore store = new DocumentStore("http://localhost:8082", "LoginEko");

        static {
            DocumentConventions conventions = store.getConventions();
            conventions.setFindCollectionName(type -> {

                if (Machine.class.isAssignableFrom(type)) return "Machines";

                return DocumentConventions.defaultGetCollectionName(type);
            });


            store.initialize();

            // Create database
            // I wouldn't do this in real production code, this is just to be easier to test
            try {
                var operation = new GetDatabaseRecordOperation("LoginEko");
                var databaseRecord = store.maintenance().server().send(operation);
                if (databaseRecord == null) {
                    store.maintenance().server().send(new CreateDatabaseOperation(new DatabaseRecord("LoginEko")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
