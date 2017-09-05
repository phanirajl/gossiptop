package com.rustyrazorblade.gossiptop

import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Label
import org.neo4j.graphdb.Node
import org.neo4j.graphdb.ResourceIterator
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import java.io.File

data class CassandraNode(val ip: String)

class TraceDB(val db: GraphDatabaseService) {

    // update the state
    fun createNode(ip: String) {
        var label = Label.label("server")

        val tx = db.beginTx()
        var node = db.createNode(*arrayOf(label))
        node.setProperty("ip", ip)
        tx.success()
    }

    // fetch all the nodes
    fun listAllNodes() : ArrayList<CassandraNode> {
        var nodes = db.findNodes(Label.label("server"))
        var result = arrayListOf<CassandraNode>()
        for (node in nodes) {
            result.add(CassandraNode(node.getProperty("ip") as String))
        }
        return result
    }
}