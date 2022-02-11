import com.google.gson.GsonBuilder

import java.time.ZonedDateTime
import java.util.{Date, UUID}

class SampleModel(
  var name: String = "",
  var birthDate: Date = null,
  var id: UUID = null
) {

}

object SampleModel {
  def main(args: Array[String]): Unit = {
    val model = SampleModel("John", Date.from(ZonedDateTime.now.toInstant), UUID.randomUUID)
    println(model)
    val gson = new GsonBuilder().setPrettyPrinting().create
    val json = gson.toJson(model)
    println(json)
    val deserializedModel = gson.fromJson(json, classOf[SampleModel])
    println(deserializedModel)
  }
}
