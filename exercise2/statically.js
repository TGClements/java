class Statically {
  //fix this code, so all of the instantiation and console.logs() work.  Try not to change the signature of the class, unless absolutely necessary.
  static #glue = 'Epoxy';
  jello = 'Jello';

  getPrivateInstanceFieldGlue() {
    return Statically.#glue;
  }
  static moveAndShake() {
    console.log('Never stagnate in life.  Be agile, change, and improve...');
  }

  static stubborn() {
    this.moveAndShake();
    console.log("Please don't make me change... I just don't like it...");
  }

  static explain() {
    Statically.stubborn();
    console.log(this.#glue);
    //write an explanation for how the keyword static behaves differently in javascript vs. java.
    console.log(
      'With static variables in Java, the variable is only allocated its memory once, on the initial load of the program. In JS it is shared between any instances of a class. -variables. Static methods in java dont need an object instance for them to be able to be called. Static methods in js, however, need to be called by the classname, like statically.doMethod().'
    );
  }
}

//get the below code to run correctly without errors:  Make sure you explain what you did in the the explain() method, defined in the class.  Do NOT remove the 'static' keyword from the explain() method.

const stats = new Statically();

Statically.moveAndShake();
Statically.stubborn();
Statically.explain();

console.log(stats.getPrivateInstanceFieldGlue());
console.log(stats.jello);

//Once you have finished getting statistically.js to run, refactor the code here in Java.
