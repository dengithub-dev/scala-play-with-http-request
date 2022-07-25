/*Build Setting
scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked"
)
libraryDependencies ++=  Seq(
  "org.scalaj" %% "scalaj-http" % "2.4.2",
  "com.lihaoyi" %% "ujson" % "0.9.5"
)
*/

import scalaj.http._
import ujson._
val request: HttpRequest = Http("https://ghibliapi.herokuapp.com/vehicles")
/* This is the json requested
[
{
"id": "4e09b023-f650-4747-9ab9-eacf14540cfb",
"name": "Air Destroyer Goliath",
"description": "A military airship utilized by the government to access Laputa",
"vehicle_class": "Airship",
"length": "1,000",
"pilot": "https://ghibliapi.herokuapp.com/people/40c005ce-3725-4f15-8409-3e1b1b14b583",
"films": [
"https://ghibliapi.herokuapp.com/films/2baf70d1-42bb-4437-b551-e5fed5a87abe"
],
"url": "https://ghibliapi.herokuapp.com/vehicles/4e09b023-f650-4747-9ab9-eacf14540cfb"
},
{
"id": "d8f893b5-1dd9-41a1-9918-0099c1aa2de8",
"name": "Red Wing",
"description": "An experimental aircraft captured by Porco. Named Savoia S.21",
"vehicle_class": "Airplane",
"length": "20",
"pilot": "https://ghibliapi.herokuapp.com/people/6523068d-f5a9-4150-bf5b-76abe6fb42c3",
"films": [
"https://ghibliapi.herokuapp.com/films/ebbb6b7c-945c-41ee-a792-de0e43191bd8"
],
"url": "https://ghibliapi.herokuapp.com/vehicles/d8f893b5-1dd9-41a1-9918-0099c1aa2de8"
},
{
"id": "923d70c9-8f15-4972-ad53-0128b261d628",
"name": "Sosuke's Boat",
"description": "A toy boat where Sosuke plays",
"vehicle_class": "Boat",
"length": "10",
"pilot": "https://ghibliapi.herokuapp.com/people/a10f64f3-e0b6-4a94-bf30-87ad8bc51607",
"films": [
"https://ghibliapi.herokuapp.com/films/758bf02e-3122-46e0-884e-67cf83df1786"
],
"url": "https://ghibliapi.herokuapp.com/vehicles/923d70c9-8f15-4972-ad53-0128b261d628"
}
]
*/
val response = request.asString
val data = response.body
val json = ujson.read(data)

/*val tuples = json(0)("films")(0).str.map { item => 
    item
}*/
val tuples = json.arr.map { item => 
    println(item("id").value)
    println(item("films")(0).str)
}

//println(tuples)
//println(json(0)("id").str)

/* Sample #2 with map and if condition
import scalaj.http._
import ujson._
val request: HttpRequest = Http("https://ghibliapi.herokuapp.com/vehicles")
val response = request.asString
val data = response.body
val json = ujson.read(data)
val myIdlist = List( "1", "2"," 3" )
val myId = "4e09b023-f650-4747-9ab9-eacf14540cfb"
val tuples = json.arr.map { item => 
    //println(item("id").value)
    if (item("id").str == myId) {
      //println(item("films")(0).str)
      true
    } 
}
println(myIdlist.map(x => x *2))
println(tuples)
//println(myIdlist.map(item => println(item)))
//println(tuples)
//println(json(0)("id").str)
*/

//result
/*
4e09b023-f650-4747-9ab9-eacf14540cfb
https://ghibliapi.herokuapp.com/films/2baf70d1-42bb-4437-b551-e5fed5a87abe
d8f893b5-1dd9-41a1-9918-0099c1aa2de8
https://ghibliapi.herokuapp.com/films/ebbb6b7c-945c-41ee-a792-de0e43191bd8
923d70c9-8f15-4972-ad53-0128b261d628
https://ghibliapi.herokuapp.com/films/758bf02e-3122-46e0-884e-67cf83df1786
*/

/* latest code

import scalaj.http._
import ujson._
val request: HttpRequest = Http("https://ghibliapi.herokuapp.com/vehicles")
val response = request.asString
val data = response.body
val json = ujson.read(data)
val myIdlist = List("1", "2", "3")
val myId = "4e09b023-f650-4747-9ab9-eacf14540cfb"
val tuples = json.arr.map { item =>
  //println(item("id").value)
  item("id").str == myId

}
val totalIdlist = 0 +: myIdlist :+ 4
println(totalIdlist)
println(tuples)
// for comprehensions
val alternativePairs = for {
  number <- totalIdlist
  //letter <- List('a', 'b', 'c')
} println(s"$number")
//println(myIdlist.map(item => println(item)))
//println(tuples)
//println(json(0)("id").str)

*/