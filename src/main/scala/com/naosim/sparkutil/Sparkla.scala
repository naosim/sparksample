package com.naosim.sparkutil

import spark._

/**
 * Created by nao_pillows on 2015/06/20.
 */
object Sparkla {
  def get(path: String, action: (Request, Response) => AnyRef) = {
    Spark.get(route(path, action));
  }

  def route(path: String, action: (Request, Response) => AnyRef):Route = new Route(path) {
    override def handle(request: Request, response: Response): AnyRef = {
      action(request, response)
    };
  };

  def staticFileLocation(path: String): Unit = {
    Spark.staticFileLocation(path);
  };
}
