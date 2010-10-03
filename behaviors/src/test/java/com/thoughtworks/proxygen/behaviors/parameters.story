Story: Parameters work

Scenario: one parameter

Given an interface method
  void hi(String s1)
When a null class is generated
Then it is the equivalent of
  public void hi(String s1) {
  }
