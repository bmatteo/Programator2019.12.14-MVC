function validateFormFields() {
  var sex = document.forms["bmiForm"]["sex"].value;
  if (sex == "MAN" || sex == "WOMAN") {
    return true;
  } else {
    return false;
  }
}