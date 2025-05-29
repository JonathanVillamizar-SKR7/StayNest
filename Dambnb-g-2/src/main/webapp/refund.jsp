<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Refund & Cancellation Policy - StayNest</title>
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
			<h1 class="mb-4">Refund & Cancellation Policy</h1>
			<p>At StayNest, we strive to make your experience seamless and
				transparent. Our refund and cancellation policies are designed to
				provide flexibility while respecting the policies set by our
				property partners.</p>

			<h5 class="mt-4">Cancellation Policy</h5>
			<ul>
				<li>Cancellations made 7 days before the check-in date are
					eligible for a full refund.</li>
				<li>Cancellations made within 7 days of the check-in date may
					be subject to partial refunds, depending on the property’s policy.</li>
				<li>Last-minute cancellations (within 24 hours of check-in) are
					non-refundable.</li>
			</ul>

			<h5 class="mt-4">Refund Process</h5>
			<ul>
				<li>Refunds are processed within 5-7 business days to the
					original payment method.</li>
				<li>You will receive a confirmation email once the refund is
					initiated.</li>
			</ul>

			<h5 class="mt-4">Modifications</h5>
			<p>If you need to change your reservation, contact us at least 48
				hours before your check-in date to avoid additional charges.</p>

			<p class="mt-4">
				For further assistance, reach out to us at <a
					href="mailto:support@staynest.com">support@staynest.com</a>.
			</p>

			<p class="mt-3">We appreciate your understanding and cooperation.</p>
		</section>
	</main>
	<%@ include file="Footer.jsp"%>

</body>
</html>
