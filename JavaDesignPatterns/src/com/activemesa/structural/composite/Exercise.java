package com.activemesa.structural.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
  public int value;

  // please leave this constructor as-is
  public SingleValue(int value)
  {
    this.value = value;
  }

  @Override
  public Iterator<Integer> iterator() {
    return Collections.singleton(value).iterator();
  }

  @Override
  public void forEach(Consumer<? super Integer> action) {
    action.accept(value);
  }

  @Override
  public Spliterator<Integer> spliterator() {
    return Collections.singleton(value).spliterator();
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
    int sum = 0;
    for (ValueContainer v : this) {
      for (Integer i : v) {
        sum += i;
      }
    }

    return sum;
  }
}

public class Exercise {

  public static void main(String[] args) {
    SingleValue singleValue = new SingleValue(2);
    ManyValues manyValues = new ManyValues();
    manyValues.add(6);
    manyValues.add(7);

    MyList myList = new MyList(List.of(singleValue));
    System.out.println(myList.sum());
    myList = new MyList(List.of(singleValue, manyValues));
    System.out.println(myList.sum());
  }
}
