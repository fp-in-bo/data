# Data

This repository contains static data needed for clients.

## How to add data
Open a PR modifying json file. 

Once merged to master the new version of the data will be automatically avaible thanks to [GitHub Pages](https://pages.github.com/).

### Example
You can modifify the [events/all.json](events/all.json) file, and the result we be deployed in https://fp-in-bo.github.io/data/events/all.json

## Continuous Integration
Manual JSON editing is error prone, so we check JSON files in continuous integration.

The [script](scripts/validateJson.kts) is written using [kscript](https://github.com/holgerbrandl/kscript) and it's embedding kscript installer so you execute it with:

    scripts/validateJson.kts events/all.json
    
It will download all required dependencies on first run.

Kscript can also produce standalone binaries containing a compiled copy of the script, as well as all declared dependencies (fatjar).

On Travis we are executing the script in this way, so if you need to modify it, remember to update also the binay version using

    kscript --package validateJson.kts

