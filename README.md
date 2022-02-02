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
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
<p>
The aim of this project is to create a Minecraft modpack management system comparable to the
<a href="https://www.example.com">FTB</a> and <a href="https://www.example.com">Technic</a>
launchers. It consists of several sub-systems, including a client program (
<a href="https://www.example.com">GUI</a> and <a href="https://www.example.com">CLI versions</a>
) for downloading, installing, and managing their installed modpacks, an
<a href="https://www.example.com">authentication API</a>
for users to log in to their SMM accounts, a
<a href="https://www.example.com">RESTful API</a> for the server functions, and a
<a href="https://www.example.com">website</a> for modpack documentation, mod help,
mod author accreditation, and user account management.
</p>



<!-- BUILT WITH -->
### Built With
This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* [Java 17](https://www.oracle.com/java/)
* [Scala 3.1](https://www.scala-lang.org/)
* [JavaFX](https://openjfx.io/)
* [Gson](https://github.com/google/gson)
* [Angular](https://angular.io/)
* [JQuery](https://jquery.com)

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



<!-- ROADMAP -->
## Roadmap

- [ ] ___Alpha release___
  - [ ] Mod download mechanism
  - [ ] Launcher Profile manipulation mechanism
  - [ ] Primary API architecture, design, and skeleton
  - [ ] Primary API database tables
  - [ ] Primary API pack download tables endpoints
  - [ ] Client application architecture
  - [ ] Client launch mechanism
  - [ ] Client application logic implementation
  - [ ] Client CLI mode

- [ ] __Alpha update__
  - [ ] Authentication API architecture, design, skeleton
  - [ ] Authentication API implementation and testing
  - [ ] Primary API authentication integration
  - [ ] Primary API Client VCS endpoints
  - [ ] Website architecture, design, and skeleton
  - [ ] Website landing page & login implemented
  - [ ] Website client download & documentation pages
  - [ ] Client self-update & login features implemented

- [ ] __Alpha update__
  - [ ] Primary API pack VCS endpoints
  - [ ] Primary API pack update & details manipulation endpoints
  - [ ] Primary API author accreditation endpoints
  - [ ] Primary API public server registration endpoints
  - [ ] Primary API new endpoints testing
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



<!-- DEVELOPMENT CYCLES -->
### Development Cycles
<p>
This project is developed using the Scrum methodology, as much as that can be followed by a solo dev.
Current sprint progress for this project can be watched
<a href="https://www.example.com">here</a>,
as well as simply following the sub-branches of the current sprint branch.
</p>

<!-- BRANCHING STRATEGY -->
#### Branching Strategy
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



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
