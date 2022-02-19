package net.mtgsaber.smm.client.util

import java.util.Optional
import scala.language.implicitConversions

/**
 * Conversions between Scala Option and Java 8 Optional.
 * Source: https://gist.github.com/julienroubieu/fbb7e1467ab44203a09f
 */
object JavaOptionals {
  implicit def toRichOption[T](opt: Option[T]): RichOption[T] = new RichOption[T](opt)
  implicit def toRichOptional[T](optional: Optional[T]): RichOptional[T] = new RichOptional[T](optional)
}

class RichOption[T] (opt: Option[T]) {

  /**
   * Transform this Option to an equivalent Java Optional
   */
  def toOptional: Optional[T] = Optional.ofNullable(opt.orNull.asInstanceOf[T])
}

class RichOptional[T] (opt: Optional[T]) {

  /**
   * Transform this Optional to an equivalent Scala Option
   */
  def toOption: Option[T] = if (opt.isPresent) Some(opt.get()) else None
}
