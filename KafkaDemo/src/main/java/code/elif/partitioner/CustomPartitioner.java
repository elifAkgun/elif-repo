package code.elif.partitioner;

import code.elif.model.TrackInfo;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

public class CustomPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes,
                         Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitionInfos =
                cluster.availablePartitionsForTopic(topic);

        TrackInfo trackInfo = (TrackInfo) value;

        if ("37.2431".equals(trackInfo.getLatitude())
                && "115.793".equals(trackInfo.getLongitude())) {
            return 5;
        }
        return Math.abs(Utils.murmur2(keyBytes) % partitionInfos.size() - 1);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
