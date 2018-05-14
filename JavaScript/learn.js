function sayHi() {   // (1)
  alert( "Привет" );
}

var func = sayHi;    // (2)
func(); // Привет    // (3)

sayHi = null;
//sayHi();             // ошибка (4)
func();
