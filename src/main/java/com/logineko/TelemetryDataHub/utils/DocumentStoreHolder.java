package com.logineko.TelemetryDataHub.utils;

import com.logineko.TelemetryDataHub.model.domain.Machine;
import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;

public class DocumentStoreHolder {
    private static class DocumentStoreContainer {
        public static final IDocumentStore store = new DocumentStore("http://localhost:8080", "LoginEko");

        static {
            DocumentConventions conventions = store.getConventions();
            conventions.setFindCollectionName(type -> {

                if (Machine.class.isAssignableFrom(type))
                    return "Machines";

                return DocumentConventions.defaultGetCollectionName(type);
            });


            store.initialize();
        }
    }

    public static IDocumentStore getStore() {
        return DocumentStoreContainer.store;
    }
}
