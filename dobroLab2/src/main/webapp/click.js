function handleClick(event) {
    var radius = parseFloat(document.getElementById("radius_hidden").value);
    if (isNaN(radius) || radius <= 0) {
        alert("Please, choose the R before clicking on the area");
        return;
    }
    const canvas = document.getElementById("graphCanvas");
    const rect = canvas.getBoundingClientRect();

    // Координаты клика относительно canvas
    const clickX = event.clientX - rect.left;
    const clickY = event.clientY - rect.top;

    // Координаты центра canvas
    const centerX = canvas.width / 2;
    const centerY = canvas.height / 2;

    // Пересчет в координаты относительно центра и масштабирование
    const x = (clickX - centerX)/200*radius;
    const y = (centerY - clickY)/200*radius;
    console.log("x: "+ x);
    console.log("y: " + y);
    if (x<-2 || x>2){
        alert("X must be in [-2,2] interval");
    }else if(y<-3 || y>3){
        alert("Y must be in [-3,3] interval");
    }else{
        console.log("Click at X: " + clickX + ", Y: " + clickY);
        console.log("Transformed X: " + x.toFixed(2) + ", Transformed Y: " + y.toFixed(2));

        // Устанавливаем вычисленные значения в форму
        document.getElementById('x_value').value = x.toFixed(2);
        document.getElementById('y_value').value = y.toFixed(2);

        // Устанавливаем флаг, что был клик по изображению
        document.getElementById('image_click').value = "true";

        // Отправляем форму для обработки на сервере
        document.getElementById('coords_form').submit();
    }
}

function validateForm() {
    var x = document.getElementById("x_value").value;
    var y = document.getElementById("y_value_input").value || document.getElementById("y_value").value;
    var radius = document.getElementById("radius_hidden").value;

    if (isNaN(y) || y < -3 || y > 3) {
        alert("Y must be in [-3,3] interval");
        return false;
    }
    if (!y) {
        alert("Please, choose the Y");
        return false;
    }

    if (!x) {
        alert("Please, choose the X");
        return false;
    }

    if (!radius) {
        alert("Please, choose the R");
        return false;
    }

    document.getElementById('y_value').value = y;

    return true;
}

function setR(value) {
    document.getElementById("radius_hidden").value = value;
    document.querySelectorAll('.radius-button').forEach(btn => btn.classList.remove('selected'));
    document.getElementById("r" + value).classList.add('selected');
}

function setX(value) {
    document.getElementById("x_value").value = value;
    document.querySelectorAll('.x-button').forEach(btn => btn.classList.remove('selected'));
    document.getElementById("x" + value).classList.add('selected');
}