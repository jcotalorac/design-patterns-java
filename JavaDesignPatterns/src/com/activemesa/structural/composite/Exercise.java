package com.activemesa.structural.composite;

import java.util.ArrayList;
import java.util.Collection;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
  public int value;

  // please leave this constructor as-is
  public SingleValue(int value)
  {
    this.value = value;
  }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
  // please leave this constructor as-is
  public MyList(Collection<? extends ValueContainer> c)
  {
    super(c);
  }

  public int sum()
  {
    // todo
  }
}

public class Exercise {
}
