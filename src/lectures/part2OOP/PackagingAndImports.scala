package lectures.part2OOP

import playground.{HeroWomans, Heroes => Donat}
//import playground._   //ezzel mindent importál

object PackagingAndImports extends App {

  sayHello

  val hero = new Donat // Ez valójában a 'Heroes' osztály, csak most át van nevezve
  val heroWoman = new HeroWomans

}
