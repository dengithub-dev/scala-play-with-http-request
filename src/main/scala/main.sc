import scalaj.http._
import ujson._

object apiPost {
   
  def main(args: Array[String]): Unit = {
   
    val url = ""
    //val topic = readLine("Topic? ")
    //val description = readLine("Description? ")

    val data = s"""{
      "topic": "https://stackoverflow.com/questions/59848009/how-do-i-post-json-data-in-scalaj",
      "description": "posting in json in scalaj.http"
    }"""

    val postRequest: HttpRequest = Http(url)
    val postStatus = postRequest.postData(data).header("content-type", "application/json").asString.code
    if (postStatus < 400 ) println("success...") else println("failed")
  }
}
