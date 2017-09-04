package com.rustyrazorblade.gossiptop

import com.rustyrazorblade.gossiptop.GossipServiceGrpc.GossipServiceImplBase
import io.grpc.stub.StreamObserver
import org.neo4j.graphdb.GraphDatabaseService

class GossipListenerService(db: TraceDB) : GossipServiceImplBase() {

    override fun updateState(request: GossipServer.State?, responseObserver: StreamObserver<GossipServer.Empty>?) {
        super.updateState(request, responseObserver)
        responseObserver!!.onCompleted()
    }

}