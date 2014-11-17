package mydfs.storage.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import mydfs.storage.server.StorageServer;
import mydfs.storage.tracker.StorageTracker;

import org.junit.Test;

public class StorageServerTest {
	
	@Test
	public void startStorageServer() throws IOException{
		StorageServer storageServer=new StorageServer(9999,"/data/mydfs/store",4,"192.168.1.110");
		storageServer.startServer();
	}
	@Test
	public void upload() throws IOException{
		StorageTracker client=new StorageTracker("127.0.0.1", 9999);
		InputStream inputStream = new FileInputStream("/home/wuqiwei/hs_err_pid2421.log");
		String storepath = client.upload(inputStream,"log");
		System.out.println(storepath);
	}
	@Test
	public void remove(){
		StorageTracker client=new StorageTracker("127.0.0.1", 9999);
		String url="http://www.jobs.com/group/M00/78/79/53D9-34E2-4110-BDBA-8BF808E2C4BD.swf";
		boolean success = client.removeData(url);
		System.out.println("删除情况："+success);
	}
}
