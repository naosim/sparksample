package com.naosim

import com.naosim.sparkutil.Sparkla
import spark.servlet.SparkApplication
import spark.{Request, Response}

/**
 * Created by nao_pillows on 2015/06/20.
 */
class Root extends SparkApplication {
  override def init(): Unit = {
    Sparkla.get("scala", (request: Request, response: Response) => "scala");
  }
}
