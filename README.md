<div id="top"></div>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

<div align="center">
<h1 align="center">Saber Modpack Manager (SMM)</h1>
</div>

<!-- TABLE OF CONTENTS -->
<br/>
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#exectuables-&amp;-installation">Executables & Installation</a></li>
    <li>
      <a href="#development-progress">Development Progress</a>
      <ul>
        <li><a href="#branching-strategy">Branching Strategy</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
The aim of this project is to create a Minecraft modpack management system comparable to the
[FTB](https://www.feed-the-beast.com/app")
and
[Technic](https://www.technicpack.net/)
launchers.
It consists of several sub-systems, including a client program (
[GUI](https://github.com/MtgSaber/Saber-Modpack-Manager/tree/main/SMM-Client-Application)
and
[CLI versions](https://github.com/MtgSaber/Saber-Modpack-Manager/tree/main/SMM-Client-Application)
) for downloading, installing, and managing their installed modpacks, an
authentication API
for users to log in to their SMM accounts, a
[REST API](https://github.com/MtgSaber/Saber-Modpack-Manager/tree/main/SMM-Web-API)
for web service features, and a
<a href="https://www.example.com">website</a>
for modpack documentation, mod help, mod author accreditation, and user account management.


<!-- BUILT WITH -->
### Built With
This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* [Java 17](https://www.oracle.com/java/)
* [Scala 3.1](https://www.scala-lang.org/)
* [PicoCLI](https://picocli.info/)
* [JavaFX](https://openjfx.io/)
* [Gson](https://github.com/google/gson)
* [Spring](https://spring.io/projects/spring-framework)
* [Docker](https://www.docker.com/)
* [MySQL]()
* [Angular](https://angular.io/)
* [JQuery](https://jquery.com)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE -->
## Usage
<p>
Below are the usages for each module of the system:
</p>

### Client GUI
<p>
(NYI)
</p>

### Client CLI
<p>
(NYI)
</p>

### Primary API
<p>
(NYI)
</p>

### Authentication API
<p>
(NYI)
</p>

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- EXECUTABLES AND INSTALLATION -->
## Executables & Installation
<p>
Build releases for all components will be available <a href="https://www.example.com">here</a>.
</p>
<p>
To use any of the components, download them to the desired run directory, install the latest version of java,  
and run the executable jar file. For command line execution, see the  
<a href="https://www.example.com">usages</a> section for each module.
</p>

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- DEVELOPMENT CYCLES -->
## Development Progress
This project is developed using the Scrum methodology, as much as that can be followed by a solo dev.
Current sprint progress for this project can be watched
[here](https://trello.com/b/DwmO5YBq/scrum-board)
, as well as simply following the sub-branches of the current sprint branch.


<!-- BRANCHING STRATEGY -->
### Branching Strategy
<p>
The branching strategy for this project is based on the
<a href="">GitLab Flow</a> strategy.
<code><a href="">main</a></code> is considered to be production, and only contains
code from <i>completed</i> sprints. Each sprint gets its own branch, and from there the
<a href="">GitHub Flow</a> strategy is used, treating the sprint branch as <code>main</code>.
When a sprint is completed, the sprint branch is merged back into <code>main</code>
Each sprint card is branched off of its sprint branch, and merged back in when the card is complete.
This makes developing the project solo simpler to manage, while still maintaining some rigor from
the original branching strategies mentioned earlier.
</p>

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] ___Alpha release___
  - [x] Mod download mechanism
  - [ ] Launcher Profile manipulation mechanism
  - [ ] Feature Web API architecture, design, and skeleton
  - [ ] Feature Web API database tables
  - [ ] Feature Web API pack download tables endpoints
  - [x] Client application architecture
  - [ ] Client launch mechanism
  - [x] Client application logic implementation
  - [ ] Client CLI program

- [ ] __Alpha update__
  - [ ] Authentication API architecture, design, skeleton
  - [ ] Authentication API implementation and testing
  - [ ] Feature Web API authentication integration
  - [ ] Feature Web API Client VCS endpoints
  - [ ] Website architecture, design, and skeleton
  - [ ] Website landing page & login implemented
  - [ ] Website client download & documentation pages
  - [ ] Client self-update & login features implemented

- [ ] __Alpha update__
  - [ ] Feature Web API pack VCS endpoints
  - [ ] Feature Web API pack update & details manipulation endpoints
  - [ ] Feature Web API author accreditation endpoints
  - [ ] Feature Web API public server registration endpoints
  - [ ] Feature Web API new endpoints testing
  - [ ] Website pack update page
  - [ ] Website author accreditation page template
  - [ ] Website public server registration form & pages
  - [ ] Website new feature menus, links, etc.
  - [ ] Website testing

- [ ] ___Beta Release___
  - [ ] Client GUI design
  - [ ] Client GUI layout & control elements
  - [ ] Client GUI application logic bindings
  - [ ] Client GUI testing

- [ ] Road map update for full release plans

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## License

<p>
  Distributed under the MIT License. See
  <code><a href=https://github.com/MtgSaber/Saber-Modpack-Manager/blob/master/LICENSE.txt">
    LICENSE.txt
  </a></code>
  for more information.
</p>

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

<p>
Listed are some programs, services, plugins, and projects which either eased the development of this project,
assisted with my learning, helped me find answers to my questions, helped me to stay organized,
or inspired me in some way regarding the project.
</p>

* [Baeldung](https://www.baeldung.com/)
* [CLIG](https://clig.dev/)
* [Choose an Open Source License](https://choosealicense.com)
* [Best README Template](https://github.com/othneildrew/Best-README-Template)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Scala plugin for IntelliJ IDEA](https://plugins.jetbrains.com/plugin/1347-scala)
* [String Manipulation plugin for IntelliJ IDEA](https://plugins.jetbrains.com/plugin/2162-string-manipulation)
* [GitHub Desktop App](https://desktop.github.com/)
* [GitKraken](https://www.gitkraken.com/)
* [Trello](https://trello.com)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/MtgSaber/Saber-Modpack-Manager.svg?style=for-the-badge
[contributors-url]: https://github.com/MtgSaber/Saber-Modpack-Manager/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/MtgSaber/Saber-Modpack-Manager.svg?style=for-the-badge
[forks-url]: https://github.com/MtgSaber/Saber-Modpack-Manager/network/members
[stars-shield]: https://img.shields.io/github/stars/MtgSaber/Saber-Modpack-Manager.svg?style=for-the-badge
[stars-url]: https://github.com/MtgSaber/Saber-Modpack-Manager/stargazers
[issues-shield]: https://img.shields.io/github/issues/MtgSaber/Saber-Modpack-Manager.svg?style=for-the-badge
[issues-url]: https://github.com/MtgSaber/Saber-Modpack-Manager/issues
[license-shield]: https://img.shields.io/github/license/MtgSaber/Saber-Modpack-Manager.svg?style=for-the-badge
[license-url]: https://github.com/MtgSaber/Saber-Modpack-Manager/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
