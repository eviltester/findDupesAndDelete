findDupesAndDelete
==================

Find Duplicate files (same name, different extension [wma, mp3]) and Delete one of them ([wma])

A very simple script - I didn't see the point in moving it from a test to an app so I run it as a test from within an IDE.

My requirements were simple. I had taken my collection of CDs and initially converted them to WMA, over time I moved to MP3, and I had a lot of folders with both .mp3 and .wma.

I spent ages looking around for a duplication removal tool that would hunt through the disk and look for files with the same name and delete the .wma files, but keep the .mp3.

None did what I needed so I thought it would be faster to write a simple script that does it. And it was, it even ran faster.

Offloading this to GitHub just in case it helps someone else.

License: Public Domain

Use at your own risk, remember to change the paths in the code.