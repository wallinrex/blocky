# Blocky Game

_(Gamewerks corporation internal code—do not share!)_

## Credits

Primary developer: Rex Wallin

### Resources Used

+ Apache NetBeans IDE 24
+ Java 23.0.2
+ GitHub Desktop
+ Managing Commits in GitHub Desktop: https://docs.github.com/en/desktop/managing-commits/options-for-managing-commits-in-github-desktop
+ Original Code: https://github.com/psosera/blocky
+ Fisher Yates Shuffle: https://en.wikipedia.org/wiki/Fisher–Yates_shuffle
+ Project description page: https://osera.cs.grinnell.edu/ttap/data-structures-labs/the-worlds-best-internship.html
+ Git Commit Guide: https://github.com/git-guides/git-commit
+ Getting Started with Git: https://docs.github.com/en/get-started/getting-started-with-git/set-up-git
+ Generating random numbers in Java: https://www.geeksforgeeks.org/generating-random-numbers-in-java/

## Changelog

~~~console
commit 6b184487c764112867189d17511557514d24e293 (HEAD -> main, origin/main, origin/HEAD)
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 22:48:52 2025 -0600

    Reformatted

    Used Alt + Shift + F in NetBeans

commit 16c0f1220a441ef7fba0f725c2e92c2753a37980
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 22:46:36 2025 -0600

    Added random piece generation

    Using an array of all the pieces that we go through, then shuffle, then go through again, etc.

commit 4bd06c81ec7004b1dcf8d77fd156cbcca4f05f0e
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 21:27:02 2025 -0600

    Fixed clearing rows

    Put the row number in the list instead of the array representing the row and reordered `deleteRow`

commit 1b5f48d5a26c5ad46168221f1d2d9d3c8509f469
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 21:09:41 2025 -0600

    Fixed horizontal movement

    Added `processMovement` to `step` and added `break` at end of `RIGHT` case

commit 75c15106bdb39f4bc15835b771a2eaa035adf5b9
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 20:37:38 2025 -0600

    Added collision detection for rotating pieces

commit ac266a16a664c1d31561b10d9afb11bfb3f18eb8
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 19:18:48 2025 -0600

    Fixed where to print the piece

    Also replaced hardcoded value 4 with the appropriate field it came from

commit 39c6cbacf02c6e3d3451f90ed083aacdadb0ac88
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 19:16:31 2025 -0600

    Fixed collision calculations

commit efcf83bc9ed3fcb5770f8fd4a5f1829570871e39
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 19:14:18 2025 -0600

    Make pieces spawn at top and gravity go down

commit 383000dc2ec0f80bd2162cc63e857f43e0daedd1
Author: wallinrex <wallinrex@gmail.com>
Date:   Sun Feb 9 19:13:00 2025 -0600

    Changed loop bounds to avoid array out-of-bounds error
~~~
