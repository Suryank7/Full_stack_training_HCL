# College Library

## Run

From this directory, compile and run:

```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out hcl.library.Main
```

The program stores items and members in memory for the current run. Export report writes `library-report.txt` in this directory.

## Quick checks

- Add a book, magazine, and DVD, then list items and search by title.
- Register a member, borrow an available item, and return it with a late-day count.
- Borrow an item for one member, add another member to its waitlist, then return it and confirm the next member receives it.
- Try a duplicate ISBN, invalid email, missing item, and a sixth borrow for one member; each should be rejected.
