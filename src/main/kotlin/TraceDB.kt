package com.rustyrazorblade.gossiptop

import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Label
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
    fun createNode(ip: String) {
        var label = Label.label("server")

        val tx = db.beginTx()
        var node = db.createNode(*arrayOf(label))
        node.setProperty("ip", ip)
        tx.success()
    }
}