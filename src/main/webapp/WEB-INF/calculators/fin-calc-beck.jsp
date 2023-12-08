<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Annuity Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container my-4">
    <div class="row">
        <div class="col-6">
            <h1>Convert money</h1>
            <p class="lead">Select the type of annuity., the number of periods, and the interest rate.
                <br />Press enter to see the result.</p>
            <form method="POST" action="convert-money">
                <div class="btn-group mb-2" role="group" aria-label="Basic select group">
                    <select name="annuityType"  id="annuityType" class="form-select" aria-label="annuityType">
                        <option>Select an annuity</option>
                        <option <c:out value="${results.conversion == 'PV' ? 'selected' : ''}" /> value="PV">Present Value of Ordinary Annuity</option>
                        <option <c:out value="${results.conversion == 'PVD' ? 'selected' : ''}" /> value="PVD">Present value of Annuity Due</option>
                        <option <c:out value="${results.conversion == 'FV' ? 'selected' : ''}" /> value="FV">Future Value of Ordinary Annuity</option>
                        <option <c:out value="${results.conversion == 'FVD' ? 'selected' : ''}" /> value="FVD">Future Value of Annuity Due</option>
                    </select>
                </div> <!-- end select group -->

                <div class="form-group mb-2">
                    <label for="annualPayment">Your Annual Payment:</label>
                    <input value="<c:out value="${results.annualPayment}" />" type="text" class="form-control" id="annualPayment" name="annualPayment">
                    <label for="rate">Interest Rate as a percent. (e.g., put in 6 if you mean 6%):</label>
                    <input value="<c:out value="${results.rate}" />" type="text" class="form-control" id="rate" name="rate">
                    <label for="years">Years:</label>
                    <input value="<c:out value="${results.years}" />" type="text" class="form-control" id="years" name="years">

                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>


            <c:if test="${results.moneyConverted != ''}">
                <p><c:out value="${results.moneyConverted}"/></p>
            </c:if>
            <c:if test="${results.conversionError != ''}">
                <p><c:out value="${results.conversionError}"/></p>
            </c:if>

            <c:if test="${results.rateError != ''}">
                <p><c:out value="${results.rateError}"/></p>
            </c:if>
            <c:if test="${results.yearError != ''}">
                <p><c:out value="${results.yearError}"/></p>
            </c:if>
            <c:if test="${results.paymentError != ''}">
                <p><c:out value="${results.paymentError}"/></p>
            </c:if>

        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
