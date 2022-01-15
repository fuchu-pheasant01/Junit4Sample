package test.sample;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestClass1 {

	@Mock
	private SampleClass sc;
	@BeforeClass
	public static void initclass() {
		System.out.println("BeforeClass���Ă΂�܂���");
	}
	@Before
	public void init() {
		System.out.println("Before���Ă΂�܂���");
	}
	@After
	public void end() {
		System.out.println("After���Ă΂�܂���");
	}
	@AfterClass
	public static void endclass() {
		System.out.println("AfterClass���Ă΂�܂���");
	}
	
	private SampleClass sc2 = mock(SampleClass.class);
	
	@Test
	@Category(Cate1.class)
	public void testMockDoReturn() {
		doReturn(500).when(sc).kingaku(1);
		assertEquals(500, sc.kingaku(1));
	}
	
	@Test
	@Category(Cate1.class)
	public void testMockWhen() {
		when(sc.kingaku(1)).thenReturn(500);
		assertTrue(500 == sc.kingaku(1));
	}
	
	@Test
	@Category(Cate1.class)
	public void testMockFalse() {
		doReturn(500).when(sc).kingaku(1);
		assertFalse(400 == sc.kingaku(1));
		assertFalse(500 == sc.kingaku(1));
	}
	
	@Test
	@Category(Cate1.class)
	public void testMockNull() {
		String str = null;
		assertNull(str);
		assertNotNull(str);
	}
	
	@Test
	@Category(Cate1.class)
	public void testMockThrows() {
		doThrow(RuntimeException.class).when(sc).kingaku(1);
		assertThrows(RuntimeException.class, () -> sc.kingaku(1));
	}
	
	@Test
	@Category(Cate1.class)
	public void testThrowUp() {
		var lc = new SampleClass();
		assertThrows(RuntimeException.class, () -> lc.ThrowUp());
	}
	
	@Test
	@Category(Cate1.class)
	public void testKingaku() {
		var lc = new SampleClass();
		sc.hyoji();
		kansu();
		MatcherAssert.assertThat(500, equalTo(lc.kingaku(5))); 
	}
	
	private void kansu() {
		System.out.println("�֐��֔�ѕ\��");
	}
	
	@Test
	@Category(Cate2.class)
	public void mockSample() {
		var tc = spy(new SampleClass());
		doReturn(500).when(tc).kingaku(9); //kingaku�̈�����9����ꂽ��500���Ԃ�Ƃ����d�g�݂��^���I�ɍ��
		assertEquals(500, tc.kingaku(9)); //����āAspy���g��Ȃ��ꍇ�͂�9*100=900�ɂȂ邪500���Ԃ�̂ň�v����
		//when(tc.kingaku(9)).thenCallRealMethod(); //s�������g���Ă��邪kingaku()���\�b�h���g��������9�̎��������ۂ̃��\�b�h���ĂԂ��Ƃɂ��܂��B
		//assertEquals(500, tc.kingaku(9)); //����āA��v���Ȃ��B
		doThrow(Exception.class).when(tc).kingaku(8); // kingaku�̈�����8����ꂽ��Exception��O�𔭐�����d�g�݂��^���I�ɍ��B
		System.out.println("�I���ł��B");
	}

	@Test
	@Category(Cate2.class)
	public void mockList() {
		List<?> list = mock(List.class);
		doReturn(3).when(list).size();
		doReturn("mockde").doReturn("dg").when(list).get(0);
		doReturn("one").when(list).get(1);
		//assertEquals("mockde",list.get(0));
		System.out.println(list.get(0) +  "���X�g�ʉ�" + list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
}