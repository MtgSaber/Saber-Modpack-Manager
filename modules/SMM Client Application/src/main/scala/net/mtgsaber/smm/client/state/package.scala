package net.mtgsaber.smm.client

/**
 * Classes for accessing internal states, such as execution contexts and configurations.
 */
package object state {
  enum ApplicationExecutionContextCategories {
    case SMMAPICalls
    case RoutineSubtasks
  }
}
