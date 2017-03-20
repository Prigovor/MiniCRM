/**
 * Created by Prigovor on 20.03.2017.
 */

var count = document.getElementById("countCart");
var button1 = document.getElementById("btnBuy1");
var button2 = document.getElementById("btnBuy2");
var button3 = document.getElementById("btnBuy3");

function handler() {
    count.innerHTML++;
}

btnBuy1.addEventListener("click", handler);
btnBuy2.addEventListener("click", handler);
btnBuy3.addEventListener("click", handler);
