class HelloWorld(private val message: String){
  var messageToShow: String = "Hello World, this is a message from: ${message}"
  
  fun showHelloAtConsole(){
    println(messageToShow)
  }
  
}
