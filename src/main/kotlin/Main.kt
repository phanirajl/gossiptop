package com.rustyrazorblade.gossiptop

import io.grpc.Server
import io.grpc.ServerBuilder
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import java.io.File


fun main(args: Array<String>) {
    println("Running the server!")

    var neodb = GraphDatabaseFactory().newEmbeddedDatabase(File("/tmp/db/whatever"))
    var db = TraceDB(neodb)
    var server = ServerBuilder.forPort(5000).addService(GossipListenerService(db)).build()
    server.awaitTermination()

}


