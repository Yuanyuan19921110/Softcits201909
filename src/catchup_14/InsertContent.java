package catchup_14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	public static void insert(String fileName, long pos, String insertContent)
			throws IOException {
		File temp = File.createTempFile("temp.txt", null);
		temp.deleteOnExit();
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
				// 使用临时文件来保存插入点后的数据
				FileOutputStream tmpOut = new FileOutputStream(temp);
				FileInputStream tmpIn = new FileInputStream(temp)) {
			raf.seek(pos);
			// ------下面代码将插入点后的内容读入临时文件中保存------
			byte[] bbuf = new byte[1024];
			// 用于保存实际读取的字节数
			int hasRead = 0;
			// 使用循环方式读取插入点后的数据,并将pos后面的内容写入到临时文件
			while ((hasRead = raf.read(bbuf)) > 0) {
				// 将读取的数据写入临时文件
				tmpOut.write(bbuf, 0, hasRead);
			}
			// ----------下面代码插入内容----------
			// 把文件记录指针重新定位到pos位置
			raf.seek(pos);
			// 追加需要插入的内容
			raf.write(insertContent.getBytes());
			// 追加临时文件中的内容
			while ((hasRead = tmpIn.read(bbuf)) > 0) {
				raf.write(bbuf, 0, hasRead);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		insert("test.txt", 7, "<here is the insert content>");
	}
}
