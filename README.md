NSS-TODO-CJ List (v1.0)
=======================

Small PHP web script to allow multiple developers on a project maintain a communal TODO list to help development, with useful features.

Thanks to Andrew Chapman/ThoughtPlay for funding/ideas.

Be sure to check out my cron job-less version of this script here.

Be sure to check out the simplified version of this script here.

Features
--------
<ul>
<li>Flatfile database (two files)</li>
<li>Add, Complete, Remove, Edit options</li>
<li>Coloured categories</li>
<li>Due dates, visual overdue notification</li>
<li>Attribution of todo items to different people</li>
<li>Email notification via cron with reminder date and frequency option</li>
<li>Basic file locking mechanism to make sure one developer updates at a time (avoids confusion)</li>
<li>Easy to integrate into site template/design</li>
<li>Security available through directory protection (.htaccess) not included</li>
<li>Simplified GUI at click of button, or setting</li>
</ul>

Demo & Installation
-------------
<ul>
<li>Unzip files to your todo directory</li>
<li>Make sure todo.list and categories.list are writeable by your web server</li>
<li>Open and modify settings.inc to suit your needs</li>
<li>Add a cron job for the execution of "cron.php" once per day eg:
<pre>
10 5 * * *	/path/to/php4/executable -f /path/to/todo/list/cron.php
</pre></li>
</ul>

Visit http://amadeus.maclab.org/_demo/nss-todo-cj-1.0/ to see a live demo (resets hourly).

Tips
----

<ul>
<li>You can change the visibility of all those extra options in settings.inc</li>
<li>You can modify a TODO item once you've added it by clicking to the left of the checkbox for that item</li>
<li>You can remove a category by clicking on it's name on the front page</li>
<li>You can rename/recolour a category by simply adding it again on the front page - you will be asked how you wish to proceed after that</li>
</ul>

Revision History
----------------
<p><b>1.0</b>
First release.</p>