package org.lagoscala.blogaggregator
package web.controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(web.views.html.index("Your application is ready..."))
  }

}
