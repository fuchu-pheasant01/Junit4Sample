package test.sample;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestClass2 {
	
	@Spy
	SampleClass sc;
	SampleClass sc2 = spy(new SampleClass());
	@BeforeClass
	public static void initclass() {
		System.out.println("TestClass2のBeforeClassが呼ばれました");
	}
	@AfterClass
	public static void endclass() {
		System.out.println("TestClass2のAfterClassが呼ばれました");
	}
	@Test
	@Category(Cate2.class)
	public void testSpyDoReturen() {
		doReturn(500).when(sc).kingaku(1);
		assertEquals(500, sc.kingaku(1));
	}
	
	@Test
	@Category(Cate2.class)
	public void testSpyWhen() {
		when(sc.kingaku(1)).thenReturn(500);
		assertTrue(500 == sc.kingaku(1));
	}
	
	@Test
	@Category(Cate2.class)
	public void testSpyFalse() {
		doReturn(500).when(sc).kingaku(1);
		assertFalse(400 == sc.kingaku(1));
		assertFalse(500 == sc.kingaku(1));
	}
	
	@Test
	@Category(Cate2.class)
	public void testSpyNull() {
		String str = null;
		assertNull(str);
		assertNotNull(str);
	}
	
	@Test
	@Category(Cate2.class)
	public void testMockThrows() {
		doThrow(RuntimeException.class).when(sc).kingaku(1);
		assertThrows(RuntimeException.class, () -> sc.kingaku(1));
	}
	
	@Test
	@Category(Cate2.class)
	public void hyojiTest() {
		var sc = new SampleClass();
		sc.hyoji();
		System.out.println("TestClass2のからの表示テストを実行しました。");
	}

}