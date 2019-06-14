object QueueTester
{
  def main(args: Array[String])
  {
    var queue = new Queue()
    println(queue.isEmpty())
    queue.enqueue(4)
    queue.enqueue(9)
    queue.enqueue(1)
    queue.enqueue(3)
    println(queue.isEmpty())
    println(queue.dequeue())
    println(queue.peek())
    println(queue.isEmpty())
    queue.printQueue()
  }
}

class Queue
{
  var first: Node = null
  var last: Node = null

  def enqueue(value: Int)
  {
    var temp = new Node(value)

    if(last != null)
    {
      last.next = temp
    }

    last = temp

    if(first == null)
    {
      first = last
    }
  }

  def dequeue() : Int =
  {
    if(first == null)
    {
      throw new IllegalArgumentException("Queue is empty.")
    }

    var temp = first.data
    first = first.next
    return temp
  }

  def peek() : Int =
  {
    if(first == null)
    {
      throw new IllegalArgumentException("Queue is empty.")
    }

    return first.data
  }

  def isEmpty() : Boolean =
  {
    return first == null
  }

  def printQueue()
  {
    var current: Node = first

    while(current != null)
    {
      if(current.next != null)
      {
        printf("%d ", current.data)
      }
      else
      {
        printf("%d\n", current.data)
      }
      current = current.next
    }
  }
}

class Node(val value: Int)
{
  var data: Int = value
  var next: Node = null
}
