package szu.csse.softwaretesting.ch6;
// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 6, page ??

public class GenericStack
{ 
   // Overview:  a genericStack.

   private Object[] elements;
   private int capacity = 10;
   private int index;

   public GenericStack ()
   {
      this.elements = new Object[this.capacity];
      this.index = 0; 
   }

   public void push (Object o)
      throws NullPointerException
   {  // Modifies: this
      // Effects:   If argument is null throw NullPointerException
      // else make o the newest element of this
      if (o == null)
         throw new NullPointerException ("GenericStack.push");
      if (this.index == this.capacity) 
      {
         this.capacity = this.capacity + this.capacity;
         Object[] elements_old = this.elements;
         this.elements = new Object[this.capacity];
         for (int i = 0; i < this.index; i++) this.elements[i] = elements_old[i];
         System.out.print("As it is too small, the capacity is doubled: ");
         System.out.println(this.capacity);
      }
      this.elements[this.index] = o;
      this.index++;
      
   }
   
   public Object pop () throws IllegalStateException
   {  // Modifies: this
      // Effects:   If queue is empty, throw IllegalStateException,
      // else remove and return the newest element of this
   
      if (this.index == 0)
         throw new IllegalStateException ("GenericStack.pop");
      else
      {
         this.index--;
         Object o = this.elements [ this.index ];
         this.elements [this.index] = null;
         return o;
      }
   }
   
   public Object top () throws IllegalStateException
   {  // Modifies: this
      // Effects:   If queue is empty, throw IllegalStateException,
      // else return the newest element of this
   
      if (this.index == 0)
         throw new IllegalStateException ("GenericStack.top");
      else
      {
         Object o = this.elements [ this.index - 1];
         this.elements [this.index - 1] = null;
         return o;
      }
   }
   
   public boolean isEmpty()
   { 
      return (this.index == 0); 
   }

   /*
   public String toString()
   {
      String result = "GenericStack [";
      for (int i = 0; i < this.index; i++)
      {
         result += this.elements[ i ] . toString();
         if (i < this.index - 1) {
            result += ", ";
         }
      }
      result += "]";
      return result;
   }*/
   
}
