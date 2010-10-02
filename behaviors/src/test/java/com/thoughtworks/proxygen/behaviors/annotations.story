Scenario: Annotations acted on and removed

Given an interface or class
  @MakeNull
  public class Apple {
  }
When a proxy generation is run over the compiled classes
Then Apple.NULL is generated
And Apple no longer has a @MakeNull annotation

Given an interface or class
  @MakeNull
  public interface Orange {
  }
When a proxy generation is run over the compiled classes
Then Orange.NULL is generated
And Orange no longer has a @MakeNull annotation

Given an interface or class
  @MakeProxy
  public class Pear {
  }
When a proxy generation is run over the compiled classes
Then Pear.PROXY is generated
And Pear no longer has a @MakeProxy annotation

Given an interface or class
  @MakeProxy
  public interface Banana {
  }
When a proxy generation is run over the compiled classes
Then Banana.PROXY is generated
And Banana no longer has a @MakeProxy annotation
