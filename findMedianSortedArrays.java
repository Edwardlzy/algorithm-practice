/* 
	A helper function which recursively updates k's position to extract the median.
*/
public double getkth(int[] A, int firstA, int[] B, int firstB, int k) {
	// Base case
	if (firstA > A.length - 1) return B[firstB + k - 1];
	if (firstB > B.length - 1) return A[firstA + k - 1];
	if (k == 1) return Math.min(A[firstA], B[firstB]);

	// Find the k/2th element of each array if exists.
	int medianA = (firstA + k / 2 - 1 < A.length) ? A[firstA + k / 2 - 1] : Integer.MAX_VALUE;
	int medianB = (firstB + k / 2 - 1 < B.length) ? B[firstB + k / 2 - 1] : Integer.MAX_VALUE;

	if (medianA < medianB)
		return getkth(A, firstA + k / 2, B, firstB, k - k / 2); // Only keep the right half of A and left half of B.
	else
		return getkth(A, firstA, B, firstB + k / 2, k - k / 2); // Only keep the right half of B and left half of A.
}

public double findMedianSortedArrays(int[] A, int[] B) {
	int lenA = A.length, lenB = B.length;
	int lk = (lenA + lenB + 1) / 2;
	int rk = (lenA + lenB + 2) / 2;
	return (getkth(A, 0, B, 0, lk) + getkth(A, 0, B, 0, rk)) / 2.0;
}