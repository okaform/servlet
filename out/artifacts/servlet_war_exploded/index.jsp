<%--
  Created by IntelliJ IDEA.
  User: Marvellous Okafor
  Date: 2/6/2022
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="A Work in Progress for Servlet">
  <link rel="stylesheet" href="css/correct.css">
  <link rel="stylesheet" href="css/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Ubuntu&display=swap" rel="stylesheet">
  <title>Welcome to Marvel's Servlet Page. </title>
</head>
<body>
<div class="stickyContainer">

<h2>Welcome to Marvel's Servlet page. This is where you can store your credit cards.</h2>

</div>
<picture>
  <img src="images/star-wars-galaxy-crop.jpg" alt="banner image" />
</picture>
<main>
  <h2>Input your Card Information</h2>
  <form action="submitCredit" method="post">
    <!-- This is for User's information -->
    <fieldset>
      <legend>User's Credit Card Information</legend>

        <%--Data validation in required pattern and min length--%>
      <label class="top">Full name on card*: <input type="text" name="fullname" required pattern="[A-Za-z ]+" minlength="5"
                                             title="You must have your full name. For example: James Candoitall" ></label>

        <label class="top">Credit Card Number*:
            <%--Data validation is found here. eg. minlength, maxlength, required pattern--%>
            <input type="text" name="cardNo" required placeholder="4444555566667777" required pattern="[0-9]+"
                   maxlength="16"
                   minlength="16"
                   title="Please type only numbers">
            <label class="top">Expiration date:
            </label>

            <div class="selectOption" >
            <label class="top" id="month">
                <select name="month"> <%--This is for the month option--%>
                    <option value=""></option>
                    <option value="1">01</option>
                    <option value="2">02</option>
                    <option value="3">03</option>
                    <option value="4">04</option>
                    <option value="5">05</option>
                    <option value="6">06</option>
                    <option value="7">07</option>
                    <option value="8">08</option>
                    <option value="9">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
            </label>

                <label class="top" id="year">
                    <select name="year"> <%--This is for the month option--%>
                        <option value=""></option>
                        <option value="2022">2022</option>
                        <option value="2023">2023</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                        <option value="2027">2027</option>
                        <option value="2028">2028</option>
                        <option value="2029">2029</option>
                        <option value="2030">2030</option>
                        <option value="2031">2031</option>
                        <option value="2032">2032</option>
                        <option value="2033">2033</option>
                        <option value="2034">2034</option>
                        <option value="2035">2035</option>
                        <option value="2036">2036</option>
                        <option value="2037">2037</option>
                        <option value="2038">2038</option>
                        <option value="2039">2039</option>
                        <option value="2040">2040</option>
                        <option value="2041">2041</option>
                        <option value="2042">2042</option>
                    </select>
                </label>
            </div>

    </fieldset>

    <input  class="submitBtn" type="submit" value="Store Card">
  </form>
</main>


<footer>
      <p>&copy; Simple Servlet - Marvellous Okafor
        <span>CIT 360 BYU - I</span>
</footer>
</body>
</html>

