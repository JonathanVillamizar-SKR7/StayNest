<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FAQ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/info.css">
</head>

<body>
	<%@ include file="Header.jsp"%>


	<main class="container my-5">
		<section>
			<h1 class="mb-4">Frequently Asked Questions (FAQ)</h1>
			<p>Find quick answers to the most common questions about
				StayNest.</p>

			<h5 class="mt-4">Booking Questions</h5>
			<ul>
				<li><strong>How do I book a stay?</strong><br>Simply
					search for your destination, select your dates, and choose your
					preferred accommodation.</li>
				<li><strong>Can I modify or cancel my booking?</strong><br>Yes,
					you can modify or cancel your booking through your StayNest
					account, based on the cancellation policy of the accommodation.</li>
				<li><strong>Are there any hidden fees?</strong><br>No, our
					pricing is transparent and what you see is what you pay.</li>
			</ul>

			<h5 class="mt-4">Payment Questions</h5>
			<ul>
				<li><strong>What payment methods do you accept?</strong><br>We
					accept major credit cards, PayPal, and bank transfers.</li>
				<li><strong>Is my payment information secure?</strong><br>Absolutely.
					We use state-of-the-art encryption to protect your data.</li>
			</ul>

			<h5 class="mt-4">Support Questions</h5>
			<ul>
				<li><strong>How can I contact customer service?</strong><br>You
					can reach us 24/7 via live chat, email, or phone.</li>
				<li><strong>What if I encounter an issue during my
						stay?</strong><br>Our support team is available around the clock to
					assist you with any concerns.</li>
			</ul>

			<p class="mt-4">
				Still have questions? Contact us at <a
					href="mailto:support@staynest.com">support@staynest.com</a> – we’re
				here to help!
			</p>
		</section>
	</main>
	<%@ include file="Footer.jsp"%>

</body>
</html>
