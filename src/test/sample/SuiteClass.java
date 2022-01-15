package test.sample;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({TestClass1.class, TestClass2.class})
@IncludeCategory(Cate2.class)
public class SuiteClass {

}