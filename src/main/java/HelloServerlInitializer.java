import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


public class HelloServerlInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        //负载http 请求编码解码
        channelPipeline.addLast(new HttpServerCodec());

        //实际处理请求
        channelPipeline.addLast(new HelloServerHandler());

    }
}
