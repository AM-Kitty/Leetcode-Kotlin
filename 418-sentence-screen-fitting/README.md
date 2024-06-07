<h2><a href="https://leetcode.ca/2017-01-21-418-Sentence-Screen-Fitting/">Sentence Screen Fitting</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given sentence can be fitted on the screen.

</p>

<p>The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must separate two consecutive words in a line.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> sentence = ["hello","world"], rows = 2, cols = 8
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
hello---
world---
The character '-' signifies an empty space on the screen.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> sentence = ["a", "bcd", "e"], rows = 3, cols = 6
<strong>Output:</strong> 2
<strong>Explanation:</strong> 
a-bcd- 
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> sentence = ["i","had","apple","pie"], rows = 4, cols = 5
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
i-had
apple
pie-i
had--
The character '-' signifies an empty space on the screen.
</pre>
