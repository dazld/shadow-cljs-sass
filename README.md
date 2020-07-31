## source for `shadow-cljs-sass` leiningen template

The template will create a clojure deps project with [shadow-cljs](http://shadow-cljs.org), [sass](https://sass-lang.com) and some glue tooling in a makefile.

# Using the template

This repo is _the source for the template_ - the template itself can be run like this:

- install [Leiningen](https://leiningen.org)

- run `lein new shadow-cljs-sass my-project`

## Template readme

Minimal project giving a react, reagent and shadow-cljs setup ready to go.

## Running

- Ensure you have a recent version of nodeJS installed. This was tested with node 12.8.0
- Install the `clojure` command line tools. on MacOS with homebrew this is usually as simple as `brew install clojure`.
- run `npm install`
- run `make dev`
- wait a bit
- server should be available on `localhost:9966`

## Connecting to the build

By default, `shadow-cljs` will compile the build called `:frontend`, as referenced in the file `shadow-cljs.edn`

Once the process has booted up, it will provide an `nrepl` port to the local `.shadow-cljs` directory, along with other port information. You can also see which port the nrepl is listening on in the terminal - it looks like `shadow-cljs - nREPL server started on port 59128`.

Configure your `nrepl` as usual to connect to thiis port, and once connected, and a browser is open, you may connect to the live process in the browser with the command:

`(shadow/repl :frontend)`

verify that your connection is working with the command `(js/alert "hi")` and observe that an alert has been opened in your browser.

To drop out of the CLJS connection enter the keyword `:cljs/quit` into the repl and evaluate it. You will then be back in the JVM clojure process.

## Static assets

`index.html` is provided and lives in the `public` folder. The referenced `css/main.css` will be built by the sass process. You can write pure CSS into the sass file, as sass syntax sits on top of baseline standard CSS.

JS assets will be compiled into this folder as well, but the compiled output should be ignored, like the compiled CSS.

## License

Copyright © 2019 Dan Peddle

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
