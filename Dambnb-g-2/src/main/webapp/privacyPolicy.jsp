<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Privacy Policy - StayNest</title>
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
			<h1 class="mb-4">Privacy Policy</h1>
			<p>At StayNest, your privacy is our priority. This Privacy Policy
				explains the types of personal information we collect, how we use
				it, and the security measures we employ to protect your data.</p>

			<h5 class="mt-4">Information We Collect</h5>
			<ul>
				<li>Personal Information: Name, email address, phone number,
					etc.</li>
				<li>Payment Details: Information required to complete bookings.</li>
				<li>Location Data: To enhance search accuracy and improve user
					experience.</li>
			</ul>

			<h5 class="mt-4">How We Use Your Information</h5>
			<ul>
				<li>To process bookings and manage reservations.</li>
				<li>To personalize your experience and suggest relevant stays.</li>
				<li>To communicate updates, promotions, and support.</li>
			</ul>

			<h5 class="mt-4">Data Security</h5>
			<p>We implement advanced security protocols to safeguard your
				personal information. All data is encrypted and stored securely,
				accessible only to authorized personnel.</p>

			<h5 class="mt-4">Your Rights</h5>
			<p>
				You have the right to access, modify, or delete your personal data
				at any time. For assistance, contact us at <a
					href="mailto:support@staynest.com">support@staynest.com</a>.
			</p>

			<p class="mt-4">We are committed to maintaining your trust and
				ensuring your privacy is protected with the highest standards of
				security.</p>
		</section>
	</main>
	<%@ include file="Footer.jsp"%>

</body>
</html>
