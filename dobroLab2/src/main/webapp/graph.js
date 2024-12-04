window.onload = function () {
    var canvas = document.getElementById("graphCanvas");
    var ctx = canvas.getContext("2d");

    ctx.clearRect(0, 0, canvas.width, canvas.height);  // Очищаем канвас перед отрисовкой

    ctx.save();  // Сохраняем начальное состояние

    var R = 200;  // Примерное значение радиуса

    // Сместим начало координат в центр холста
    ctx.translate(250, 250);

    // Отрисуем координатные оси
    ctx.beginPath();
    ctx.moveTo(-250, 0);
    ctx.lineTo(250, 0);
    ctx.moveTo(0, -250);
    ctx.lineTo(0, 250);
    ctx.strokeStyle = "black";
    ctx.stroke();

    // Отрисуем четверть окружности во второй координатной четверти
    ctx.beginPath();
    ctx.arc(0, 0, R, Math.PI, 1.5 * Math.PI);
    ctx.strokeStyle = "#d77dfa";
    ctx.stroke();

    // Отрисуем треугольник в первой координатной четверти
    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(-R, 0);
    ctx.lineTo(0, R);
    ctx.closePath();
    ctx.strokeStyle = "#6868ff";
    ctx.stroke();

    // Отрисуем прямоугольник в четвертой координатной четверти
    ctx.beginPath();
    ctx.rect(0, 0, R/2, -R);
    ctx.strokeStyle = "#fd4984";
    ctx.stroke();

    // Добавим текстовые обозначения для всех сторон
    ctx.font = "15px Arial";
    ctx.fillStyle = "black";

    // Обозначения осей
    ctx.fillText("R", -10, -R + 15);  // Верхняя ось
    ctx.fillText("R", R - 15, 15);     // Правая ось
    ctx.fillText("-R", -R - 25, 15);   // Левая ось
    ctx.fillText("-R", -10, R - 5);    // Нижняя ось

    // Обозначения для половин радиуса
    ctx.fillText("R/2", R/2 - 10, 15);          // По правой оси
    ctx.fillText("-R/2", -R/2 - 30, 15);        // По левой оси
    ctx.fillText("R/2", 5, R/2 + 15);           // В нижней части
    ctx.fillText("-R/2", 5, -R/2 + 15);

}

const checkboxInputs = document.getElementsByName("x[]");

function checkOnlyOne(checkbox) {
    checkboxInputs.forEach((item) => {
        if (item !== checkbox) item.checked = false;///МБ   ТУТ ПИЗДА
    });
}

checkboxInputs.forEach(function (checkbox) {
    checkbox.addEventListener("click", function () {
        checkOnlyOne(checkbox);
    });
});