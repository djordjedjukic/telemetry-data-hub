package com.logineko.telemetrydatahub.infrastructure;

import com.logineko.telemetrydatahub.model.domain.Machine;
import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentStoreHolder {
    private static class DocumentStoreContainer {
        public static final IDocumentStore store = new DocumentStore("http://localhost:8082", "LoginEko");

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

    @Bean
    public IDocumentStore getStore() {
        return DocumentStoreContainer.store;
    }
}
