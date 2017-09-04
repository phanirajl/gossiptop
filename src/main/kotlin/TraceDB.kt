package com.rustyrazorblade.gossiptop

import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import java.io.File


class TraceDB(path: String) {
    var db: GraphDatabaseService

    init {
        val fp = File(path)
        db = GraphDatabaseFactory().newEmbeddedDatabase(fp)
    }

    // update the state

    // fetch all the nodes
}